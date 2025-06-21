let patients = JSON.parse(localStorage.getItem("patients")) || [];

const form = document.getElementById("patient-form");
const list = document.getElementById("patient-list");
const searchInput = document.getElementById("search");

function savePatients() {
  localStorage.setItem("patients", JSON.stringify(patients));
}

function renderPatients(data) {
  list.innerHTML = "";
  data.forEach((p, index) => {
    list.innerHTML += `
      <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.age}</td>
        <td>${p.gender}</td>
        <td>${p.address}</td>
        <td>${p.phone}</td>
        <td>${formatDate(p.dob)}</td>
        <td><button onclick="deletePatient(${index})">Xóa</button></td>
      </tr>
    `;
  });
}

function formatDate(dob) {
  const d = new Date(dob);
  return d.toLocaleDateString("vi-VN");
}

form.addEventListener("submit", function (e) {
  e.preventDefault();

  const id = document.getElementById("patientId").value.trim();
  const name = document.getElementById("name").value.trim();
  const age = document.getElementById("age").value;
  const gender = document.getElementById("gender").value;
  const address = document.getElementById("address").value.trim();
  const phone = document.getElementById("phone").value.trim();
  const dob = document.getElementById("dob").value;

  const existingIndex = patients.findIndex(p => p.id === id);
  const patientData = { id, name, age, gender, address, phone, dob };

  if (existingIndex >= 0) {
    patients[existingIndex] = patientData;
  } else {
    patients.push(patientData);
  }

  savePatients();
  renderPatients(patients);
  form.reset();
});

function deletePatient(index) {
  if (confirm("Bạn có chắc muốn xóa?")) {
    patients.splice(index, 1);
    savePatients();
    renderPatients(patients);
  }
}

searchInput.addEventListener("input", function () {
  const keyword = this.value.toLowerCase();
  const filtered = patients.filter(p => p.name.toLowerCase().includes(keyword));
  renderPatients(filtered);
});

window.onload = () => renderPatients(patients);
