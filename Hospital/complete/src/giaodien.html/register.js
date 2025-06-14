function register() {
  clearErrors(); // Xóa lỗi cũ

  const lastname = document.getElementById("lastname").value.trim();
  const firstname = document.getElementById("firstname").value.trim();
  const fullname = `${lastname} ${firstname}`;
  const age = document.getElementById("age").value.trim();
  const cccd = document.getElementById("cccd").value.trim();
  const address = document.getElementById("address").value.trim();
  const phone = document.getElementById("phone").value.trim();
  const username = document.getElementById("username").value.trim();
  const password = document.getElementById("password").value;
  const confirmPassword = document.getElementById("confirmPassword").value;

  let hasError = false;

  if (!lastname) showError("lastname", "Họ không được để trống"), hasError = true;
  if (!firstname) showError("firstname", "Tên không được để trống"), hasError = true;

  if (!age || isNaN(age) || age < 1 || age > 120) {
    showError("age", "Tuổi phải từ 1 đến 120");
    hasError = true;
  }

  if (!cccd.match(/^\d{12}$/)) {
    showError("cccd", "CCCD phải gồm đúng 12 chữ số");
    hasError = true;
  }

  if (!address) showError("address", "Vui lòng nhập quê quán"), hasError = true;

  if (!phone.match(/^0\d{9}$/)) {
    showError("phone", "Số điện thoại phải bắt đầu bằng 0 và đủ 10 chữ số");
    hasError = true;
  }

  if (!username.match(/^\d+$/)) {
    showError("username", "Tài khoản chỉ được chứa chữ số");
    hasError = true;
  }

  if (!password || password.length < 6) {
    showError("password", "Mật khẩu phải từ 6 ký tự trở lên");
    hasError = true;
  }

  if (password !== confirmPassword) {
    showError("confirmPassword", "Mật khẩu nhập lại không khớp");
    hasError = true;
  }

  if (hasError) return;

  let users = JSON.parse(localStorage.getItem("users")) || [];

  const usernameExists = users.some(user => user.username === username);
  if (usernameExists) {
    showError("username", "Tài khoản đã tồn tại");
    return;
  }

  const newUser = {
    username,
    fullname,
    age,
    cccd,
    address,
    phone,
    password
  };

  users.push(newUser);
  localStorage.setItem("users", JSON.stringify(users));

  alert("Đăng ký thành công!");
  window.location.href = "index.html?success=1";
}

// Hiển thị lỗi dưới input
function showError(inputId, message) {
  const input = document.getElementById(inputId);
  let error = document.createElement("span");
  error.className = "error";
  error.textContent = message;
  error.style.color = "red";
  error.style.fontSize = "13px";
  error.style.display = "block";
  error.style.marginTop = "4px";
  input.insertAdjacentElement("afterend", error);
}

// Xóa toàn bộ lỗi trước khi kiểm tra lại
function clearErrors() {
  document.querySelectorAll(".error").forEach(e => e.remove());
}
