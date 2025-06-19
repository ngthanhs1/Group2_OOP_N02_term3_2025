let benhAns = JSON.parse(localStorage.getItem("benhanList")) || [];
let patients = JSON.parse(localStorage.getItem("patients")) || [];

const form = document.getElementById("benhan-form");
const list = document.getElementById("benhan-list");
const search = document.getElementById("searchBenhAn");

function renderBenhAn(data) {
  list.innerHTML = "";
  data.forEach((b, index) => {
    list.innerHTML += `
      <tr>
        <td>${b.maBenhAn}</td>
        <td>${b.maBenhNhan}</td>
        <td>${b.ngayKham}</td>
        <td>${b.trieuChung}</td>
        <td>${b.tienSuBenh}</td>
        <td>${b.maPhong}</td>
        <td>
          <button class="edit-btn" onclick="editBenhAn(${index})">Sửa</button>
          <button class="delete-btn" onclick="deleteBenhAn(${index})">Xóa</button>
        </td>
      </tr>
    `;
  });
}

form.addEventListener("submit", function (e) {
  e.preventDefault();

  const maBenhAn = document.getElementById("maBenhAn").value.trim();
  const maBenhNhan = document.getElementById("maBenhNhan").value.trim();
  const ngayKham = document.getElementById("ngayKham").value;
  const trieuChung = document.getElementById("trieuChung").value.trim();
  const tienSuBenh = document.getElementById("tienSuBenh").value.trim();
  const maPhong = document.getElementById("maPhong").value.trim();

  if (!maBenhAn || !maBenhNhan || !ngayKham || !trieuChung || !tienSuBenh || !maPhong) return;

  const exists = patients.some(p => p.id === maBenhNhan);
  if (!exists) {
    alert("Mã bệnh nhân không tồn tại!");
    return;
  }

  const existingIndex = benhAns.findIndex(b => b.maBenhAn === maBenhAn);
  const data = { maBenhAn, maBenhNhan, ngayKham, trieuChung, tienSuBenh, maPhong };

  if (existingIndex !== -1) {
    benhAns[existingIndex] = data;
  } else {
    benhAns.push(data);
  }

  localStorage.setItem("benhanList", JSON.stringify(benhAns));
  renderBenhAn(benhAns);
  form.reset();
});

function editBenhAn(index) {
  const b = benhAns[index];
  document.getElementById("maBenhAn").value = b.maBenhAn;
  document.getElementById("maBenhNhan").value = b.maBenhNhan;
  document.getElementById("ngayKham").value = b.ngayKham;
  document.getElementById("trieuChung").value = b.trieuChung;
  document.getElementById("tienSuBenh").value = b.tienSuBenh;
  document.getElementById("maPhong").value = b.maPhong;
}

function deleteBenhAn(index) {
  if (confirm("Bạn có chắc muốn xóa bệnh án này?")) {
    benhAns.splice(index, 1);
    localStorage.setItem("benhanList", JSON.stringify(benhAns));
    renderBenhAn(benhAns);
  }
}

search.addEventListener("input", function () {
  const value = this.value.toLowerCase();
  const filtered = benhAns.filter(b => 
    b.maBenhAn.toLowerCase().includes(value) || b.maBenhNhan.toLowerCase().includes(value)
  );
  renderBenhAn(filtered);
});

renderBenhAn(benhAns);
