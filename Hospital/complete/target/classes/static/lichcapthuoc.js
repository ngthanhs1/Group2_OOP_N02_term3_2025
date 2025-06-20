let capThuocList = JSON.parse(localStorage.getItem("capThuocList")) || [];
let benhAns = JSON.parse(localStorage.getItem("benhanList")) || [];
let patients = JSON.parse(localStorage.getItem("patients")) || [];

const form = document.getElementById("capthuoc-form");
const list = document.getElementById("lich-list");
const search = document.getElementById("searchLich");

function renderCapThuoc(data) {
  list.innerHTML = "";
  data.forEach((item, index) => {
    list.innerHTML += `
      <tr>
        <td>${item.maLich}</td>
        <td>${item.maBenhAn}</td>
        <td>${item.maBenhNhan}</td>
        <td>${item.ngay}</td>
        <td>${item.thuoc}</td>
        <td>${item.soLuong}</td>
        <td>
          <button class="edit-btn" onclick="editCapThuoc(${index})">Sửa</button>
          <button class="delete-btn" onclick="deleteCapThuoc(${index})">Xóa</button>
        </td>
      </tr>
    `;
  });
}

form.addEventListener("submit", function (e) {
  e.preventDefault();

  const maLich = document.getElementById("maLich").value.trim();
  const maBenhAn = document.getElementById("maBenhAn").value.trim();
  const maBenhNhan = document.getElementById("maBenhNhan").value.trim();
  const ngay = document.getElementById("ngay").value;
  const thuoc = document.getElementById("thuoc").value.trim();
  const soLuong = document.getElementById("soLuong").value;

  // Kiểm tra mã bệnh án có tồn tại
  const benhAnExists = benhAns.some(b => b.maBenhAn === maBenhAn);
  if (!benhAnExists) {
    alert("Mã bệnh án không tồn tại!");
    return;
  }

  // Kiểm tra mã bệnh nhân có tồn tại
  const benhNhanExists = patients.some(p => p.id === maBenhNhan);
  if (!benhNhanExists) {
    alert("Mã bệnh nhân không tồn tại!");
    return;
  }

  const existingIndex = capThuocList.findIndex(c => c.maLich === maLich);
  const newData = { maLich, maBenhAn, maBenhNhan, ngay, thuoc, soLuong };

  if (existingIndex !== -1) {
    capThuocList[existingIndex] = newData;
  } else {
    capThuocList.push(newData);
  }

  localStorage.setItem("capThuocList", JSON.stringify(capThuocList));
  renderCapThuoc(capThuocList);
  form.reset();
});

function editCapThuoc(index) {
  const item = capThuocList[index];
  document.getElementById("maLich").value = item.maLich;
  document.getElementById("maBenhAn").value = item.maBenhAn;
  document.getElementById("maBenhNhan").value = item.maBenhNhan;
  document.getElementById("ngay").value = item.ngay;
  document.getElementById("thuoc").value = item.thuoc;
  document.getElementById("soLuong").value = item.soLuong;
}

function deleteCapThuoc(index) {
  if (confirm("Bạn có chắc chắn muốn xóa lịch này?")) {
    capThuocList.splice(index, 1);
    localStorage.setItem("capThuocList", JSON.stringify(capThuocList));
    renderCapThuoc(capThuocList);
  }
}

search.addEventListener("input", function () {
  const value = this.value.toLowerCase();
  const filtered = capThuocList.filter(item =>
    item.maLich.toLowerCase().includes(value) ||
    item.maBenhNhan.toLowerCase().includes(value) ||
    item.maBenhAn.toLowerCase().includes(value)
  );
  renderCapThuoc(filtered);
});

renderCapThuoc(capThuocList);
