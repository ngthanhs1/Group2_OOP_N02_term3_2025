let patients = [];

const form = document.getElementById("patient-form");
const list = document.getElementById("patient-list");
const searchInput = document.getElementById("search");

async function fetchPatients() {
  const res = await fetch('/api/patients');
  patients = await res.json();
  renderPatients(patients);
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
        <td>${p.dob ? formatDate(p.dob) : ""}</td>
        <td>
          <!-- Nút sửa/xóa sẽ làm sau -->
        </td>
      </tr>
    `;
  });
}

function formatDate(dob) {
  // dob có thể là chuỗi hoặc object, tùy backend trả về
  const d = new Date(dob);
  return d.toLocaleDateString('vi-VN');
}

form.addEventListener("submit", async function (e) {
  e.preventDefault();

  const id = document.getElementById("patientId").value.trim();
  const name = document.getElementById("name").value.trim();
  const age = document.getElementById("age").value;
  const gender = document.getElementById("gender").value;
  const address = document.getElementById("address").value.trim();
  const phone = document.getElementById("phone").value.trim();
  const dob = document.getElementById("dob").value;

  if (!id || !name || !age || !gender || !address || !phone || !dob) return;

  // Gửi dữ liệu lên API (cần viết API POST ở backend)
  await fetch('/api/patients', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ id, name, age, gender, address, phone, dob })
  });

  await fetchPatients();
  form.reset();
});

searchInput.addEventListener("input", function () {
  const keyword = this.value.toLowerCase();
  const filtered = patients.filter(p => p.name.toLowerCase().includes(keyword));
  renderPatients(filtered);
});

window.onload = fetchPatients;