let patients = JSON.parse(localStorage.getItem("patients")) || [];

const form = document.getElementById("patient-form");
const list = document.getElementById("patient-list");
const searchInput = document.getElementById("search");

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
        <td>${p.dob}</td>
        <td>
          <button class="action-btn edit-btn" onclick="editPatient(${index})">Sửa</button>
          <button class="action-btn delete-btn" onclick="deletePatient(${index})">Xóa</button>
        </td>
      </tr>
    `;
  });
}

function saveToLocalStorage() {
  localStorage.setItem("patients", JSON.stringify(patients));
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

  if (!id || !name || !age || !gender || !address || !phone || !dob) return;

  const existingIndex = patients.findIndex(p => p.id === id);

  const patientData = { id, name, age, gender, address, phone, dob };

  if (existingIndex !== -1) {
    patients[existingIndex] = patientData;
  } else {
    patients.push(patientData);
  }

  saveToLocalStorage();
  renderPatients(patients);
  form.reset();
});

function editPatient(index) {
  const p = patients[index];
  document.getElementById("patientId").value = p.id;
  document.getElementById("name").value = p.name;
  document.getElementById("age").value = p.age;
  document.getElementById("gender").value = p.gender;
  document.getElementById("address").value = p.address;
  document.getElementById("phone").value = p.phone;
  document.getElementById("dob").value = p.dob;
}

function deletePatient(index) {
  if (confirm("Bạn có chắc muốn xóa bệnh nhân này?")) {
    const deletedPatientId = patients[index].id;
    patients.splice(index, 1);
    saveToLocalStorage();
    renderPatients(patients);

    let medicalRecords = JSON.parse(localStorage.getItem("medicalRecords")) || [];
    medicalRecords = medicalRecords.filter(r => r.patientId !== deletedPatientId);
    localStorage.setItem("medicalRecords", JSON.stringify(medicalRecords));

    let prescriptions = JSON.parse(localStorage.getItem("prescriptions")) || [];
    prescriptions = prescriptions.filter(p => p.patientId !== deletedPatientId);
    localStorage.setItem("prescriptions", JSON.stringify(prescriptions));
  }
}

searchInput.addEventListener("input", function () {
  const keyword = this.value.toLowerCase();
  const filtered = patients.filter(p => p.name.toLowerCase().includes(keyword));
  renderPatients(filtered);
});

renderPatients(patients);

function isValidPatientId(patientId) {
  const patients = JSON.parse(localStorage.getItem("patients")) || [];
  return patients.some(p => p.id === patientId);
}

