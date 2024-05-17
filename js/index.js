async function getData() {
  const api = "http://localhost:8100/employees";
  const response = await fetch(api);

  if (response.ok == true) {
    const tableBody = document.getElementById("tableemployee");
    const data = await response.json();
    for (let i = 0; i < data.length; i++) {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${data[i].id}</td>
        <td>${data[i].adresse}</td>
        <td>${data[i].email}</td>
        <td>${data[i].nom}</td>
        <td>${data[i].prenom}</td>
        <td>${data[i].salaire}</td>
        <td>${data[i].equipe.nom}</td>
        <td>
      <button class="btn btn-primary"  data-toggle="modal" data-target="#empModal${data[i].id}">Modifier</button>
      <button class="btn btn-danger" onclick="deleteEmp(${data[i].id})">supprimer</button>
      </td>
      <!-- employee-->
    <div
      class="modal fade"
      id="empModal${data[i].id}"
      tabindex="-1"
      role="dialog"
      aria-labelledby="empModalLabel${data[i].id}"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="empModalLabel${data[i].id}">Modifier employee id ${data[i].id}</h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="recipient-name" class="col-form-label">Nom :</label>
                <input type="text" class="form-control" id="nomemp${data[i].id}" value="${data[i].nom}" required />
              </div>
              <div class="form-group">
                <label for="message-text" class="col-form-label"
                  >Prenom :</label
                >
                <input type="text" class="form-control" id="prenomemp${data[i].id}" value="${data[i].prenom}" required/>
              </div>
              <div class="form-group">
                <label for="message-text" class="col-form-label"
                  >E-mail :</label
                >
                <input type="text" class="form-control" id="mailemp${data[i].id}"value="${data[i].email}" required/>
              </div>
              <div class="form-group">
                <label for="message-text" class="col-form-label"
                  >Adresse :
                </label>
                <input type="text" class="form-control" id="adresseemp${data[i].id}" value="${data[i].adresse}" required/>
              </div>
              <div class="form-group">
                <label for="message-text" class="col-form-label"
                  >Salaire :</label
                >
                <input type="number" class="form-control" id="salaireemp${data[i].id}" value="${data[i].salaire}" required/>
              </div>
              <div class="form-group">
                <label for="message-text" class="col-form-label"
                  >Id Equipe</label
                >
                <input type="number" class="form-control" id="idequipe${data[i].id}" value="${data[i].equipe.idequipe}" required/>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-dismiss="modal"
            >
              Close
            </button>
            <button type="button" class="btn btn-primary" onclick="modifierEmp(${data[i].id})">Enregistrer</button>
          </div>
        </div>
      </div>
    </div>
      `;
      tableBody.appendChild(row);
    }
  } else {
    console.log("Erreur lors du fetch !");
  }
}

async function getequipes() {
  const api = "http://localhost:8100/equipes";
  const response = await fetch(api);

  if (response.ok == true) {
    const tableBody = document.getElementById("tableequipes");
    const data = await response.json();
    for (let i = 0; i < data.length; i++) {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${data[i].idequipe}</td>
        <td>${data[i].nom}</td>
        <td>
        <button class="btn btn-primary">Modifier</button>
        <button class="btn btn-danger">supprimer</button>
        </td>
      `;
      tableBody.appendChild(row);
    }
  } else {
    console.log("Erreur lors du fetch !");
  }
}

async function getprojets() {
  const api = "http://localhost:8100/projets";
  const response = await fetch(api);

  if (response.ok == true) {
    const tableBody = document.getElementById("tableprojets");
    const data = await response.json();
    for (let i = 0; i < data.length; i++) {
      const row = document.createElement("tr");
      row.innerHTML = `
      <td>${data[i].codeprojet}</td>
      <td>${data[i].nom}</td>
      <td>${data[i].datedebut}</td>
      <td>${data[i].duree}</td>
      <td>${data[i].equipe.nom}</td>
      <td>
      <button class="btn btn-primary">Modifier</button>
      <button class="btn btn-danger">supprimer</button>

      </td>
      `;
      tableBody.appendChild(row);
    }
  } else {
    console.log("Erreur lors du fetch !");
  }
}

async function deleteEmp(id) {
  const url = `http://localhost:8100/employee/${id}`;
  const options = {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  };

  await fetch(url, options)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Erreur !");
      }
      console.log(response.json);
    })
    .catch((error) => {
      console.error("Erreur !", error);
    });
  window.location.reload();
}

async function modifierEmp(id) {
  const nom = document.getElementById("nomemp" + id).value;
  const prenom = document.getElementById("prenomemp" + id).value;
  const email = document.getElementById("mailemp" + id).value;
  const adresse = document.getElementById("adresseemp" + id).value;
  const salaire = document.getElementById("salaireemp" + id).value;
  const idequipe = document.getElementById("idequipe" + id).value;
  console.log("Nom:", nom);
  console.log("Prénom:", prenom);
  console.log("Email:", email);
  console.log("Adresse:", adresse);
  console.log("Salaire:", salaire);
  console.log("ideuipe:", idequipe);

  const updateEmp = {
    nom: nom,
    prenom: prenom,
    email: email,
    adresse: adresse,
    salaire: salaire,
    equipe: { idequipe: idequipe }
  };

  const jsonString = JSON.stringify(updateEmp);

  const url = `http://localhost:8100/employee/${id}`;

  const options = {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: jsonString //le json
  };

  await fetch(url, options)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Erreur !");
      }
      console.log(response.json);
    })
    .catch((error) => {
      console.error("Erreur !", error);
    });
  window.location.reload();
}

async function createEmp() {
  const nom = document.getElementById("nomempX").value;
  const prenom = document.getElementById("prenomempX").value;
  const email = document.getElementById("mailempX").value;
  const adresse = document.getElementById("adresseempX").value;
  const salaire = document.getElementById("salaireempX").value;
  const idequipe = document.getElementById("idequipeX").value;
  console.log("Nom:", nom);
  console.log("Prénom:", prenom);
  console.log("Email:", email);
  console.log("Adresse:", adresse);
  console.log("Salaire:", salaire);
  console.log("idequipe:", idequipe);

  const Emp = {
    nom: nom,
    prenom: prenom,
    email: email,
    adresse: adresse,
    salaire: salaire,
    equipe: { idequipe: idequipe }
  };

  const jsonString = JSON.stringify(Emp);

  const url = `http://localhost:8100/employee`;

  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: jsonString //le json
  };

  await fetch(url, options)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Erreur !");
      }
      console.log(response.json);
    })
    .catch((error) => {
      console.error("Erreur !", error);
    });
  
  window.location.reload();
}

getData();
getequipes();
getprojets();
