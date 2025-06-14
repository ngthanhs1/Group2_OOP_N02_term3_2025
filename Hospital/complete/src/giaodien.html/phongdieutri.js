const phongForm = document.getElementById("phong-form");
const phongList = document.getElementById("phong-list");
const searchInput = document.getElementById("search");

let phongData = JSON.parse(localStorage.getItem("phongs")) || [];

function renderTable(data) {
  phongList.innerHTML = "";
  data.forEach((phong, index) => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${phong.maPhong}</td>
      <td>${phong.tenPhong}</td>
      <td>${phong.bacSi}</td>
      <td>
        <button class="edit-btn" onclick="editPhong(${index})">Sửa</button>
        <button class="delete-btn" onclick="deletePhong(${index})">Xóa</button>
      </td>
    `;
    phongList.appendChild(row);
  });
}

phongForm.addEventListener("submit", (e) => {
  e.preventDefault();
  const maPhong = document.getElementById("maPhong").value.trim();
  const tenPhong = document.getElementById("tenPhong").value.trim();
  const bacSi = document.getElementById("bacSi").value.trim();

  if (!maPhong || !tenPhong || !bacSi) return alert("Vui lòng điền đầy đủ thông tin.");

  const existingIndex = phongData.findIndex(p => p.maPhong === maPhong);
  const newData = { maPhong, tenPhong, bacSi };

  if (existingIndex !== -1) {
    phongData[existingIndex] = newData;
  } else {
    phongData.push(newData);
  }

  localStorage.setItem("phongs", JSON.stringify(phongData));
  renderTable(phongData);
  phongForm.reset();
});

function editPhong(index) {
  const p = phongData[index];
  document.getElementById("maPhong").value = p.maPhong;
  document.getElementById("tenPhong").value = p.tenPhong;
  document.getElementById("bacSi").value = p.bacSi;
}

function deletePhong(index) {
  if (confirm("Bạn chắc chắn muốn xoá?")) {
    phongData.splice(index, 1);
    localStorage.setItem("phongs", JSON.stringify(phongData));
    renderTable(phongData);
  }
}

searchInput.addEventListener("input", () => {
  const keyword = searchInput.value.toLowerCase();
  const filtered = phongData.filter(p =>
    p.maPhong.toLowerCase().includes(keyword) || p.tenPhong.toLowerCase().includes(keyword)
  );
  renderTable(filtered);
});

renderTable(phongData);
