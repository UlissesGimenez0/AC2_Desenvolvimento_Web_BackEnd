const BASE_URL = "http://localhost:8081";

/* ================= PROJETO ================= */

async function criarProjeto() {
  const nome = document.getElementById("projNome").value;
  const dataInicio = document.getElementById("projData").value;

  const res = await fetch(`${BASE_URL}/projetos`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ nome, dataInicio })
  });

  if (res.ok) {
    alert("Projeto criado com sucesso!");
  } else {
    alert("Erro ao criar projeto");
  }
}

async function buscarProjeto() {
  const id = document.getElementById("projId").value;

  const res = await fetch(`${BASE_URL}/projetos/${id}`);

  if (!res.ok) {
    document.getElementById("resProjeto").innerText = "Projeto não encontrado";
    return;
  }

  const data = await res.json();

  document.getElementById("resProjeto").innerText =
    JSON.stringify(data, null, 2);
}

/* 🔥 CORRIGIDO: agora existe no backend */
async function listarProjetos() {
  const res = await fetch(`${BASE_URL}/projetos`);

  const data = await res.json();

  document.getElementById("listaProjetos").innerText =
    JSON.stringify(data, null, 2);
}

/* 🔥 CORRIGIDO: endpoint certo + query param */
async function listarPorPeriodo() {
  const inicio = document.getElementById("inicio").value;
  const fim = document.getElementById("fim").value;

  const res = await fetch(
    `${BASE_URL}/projetos/data?inicio=${inicio}&fim=${fim}`
  );

  if (!res.ok) {
    document.getElementById("listaPeriodo").innerText =
      "Erro ao buscar por período";
    return;
  }

  const data = await res.json();

  document.getElementById("listaPeriodo").innerText =
    JSON.stringify(data, null, 2);
}

/* ================= FUNCIONÁRIO ================= */

async function criarFuncionario() {
  const nome = document.getElementById("funcNome").value;

  const res = await fetch(`${BASE_URL}/funcionarios`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ nome })
  });

  if (res.ok) {
    alert("Funcionário criado!");
  } else {
    alert("Erro ao criar funcionário");
  }
}

async function buscarProjetosFuncionario() {
  const id = document.getElementById("funcId").value;

  const res = await fetch(`${BASE_URL}/funcionarios/${id}/projetos`);

  if (!res.ok) {
    document.getElementById("resFunc").innerText =
      "Funcionário não encontrado ou sem projetos";
    return;
  }

  const data = await res.json();

  document.getElementById("resFunc").innerText =
    JSON.stringify(data, null, 2);
}

/* ================= VINCULAR ================= */

async function vincular() {
  const idProjeto = document.getElementById("vincProj").value;
  const idFuncionario = document.getElementById("vincFunc").value;

  const res = await fetch(
    `${BASE_URL}/projetos/${idProjeto}/funcionario/${idFuncionario}`,
    { method: "POST" }
  );

  if (res.ok) {
    alert("Funcionário vinculado ao projeto!");
  } else {
    alert("Erro ao vincular");
  }
}

/* ================= SETOR ================= */

async function criarSetor() {
  const nome = document.getElementById("setorNome").value;

  const res = await fetch(`${BASE_URL}/setores`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ nome })
  });

  if (res.ok) {
    alert("Setor criado!");
  } else {
    alert("Erro ao criar setor");
  }
}

async function buscarSetor() {
  const id = document.getElementById("setorId").value;

  const res = await fetch(`${BASE_URL}/setores/${id}`);

  if (!res.ok) {
    document.getElementById("resSetor").innerText = "Setor não encontrado";
    return;
  }

  const data = await res.json();

  document.getElementById("resSetor").innerText =
    JSON.stringify(data, null, 2);
}