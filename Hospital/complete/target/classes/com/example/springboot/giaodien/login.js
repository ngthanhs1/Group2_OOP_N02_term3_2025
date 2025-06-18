function login() {
  const username = document.getElementById("username").value.trim(); // Dãy số nhưng vẫn dùng dưới dạng chuỗi
  const password = document.getElementById("password").value;

  const users = JSON.parse(localStorage.getItem("users")) || [];

  const foundUser = users.find(
    user => user.username === username && user.password === password
  );

  if (foundUser) {
    alert("Đăng nhập thành công!");
    window.location.href = "dashboard.html"; 
  } else {
    showMessage("Tài khoản hoặc mật khẩu không đúng.", "red");
  }
}

function showMessage(message, color) {
  let msgDiv = document.getElementById("message");
  if (!msgDiv) {
    msgDiv = document.createElement("div");
    msgDiv.id = "message";
    document.querySelector(".login-container").appendChild(msgDiv);
  }
  msgDiv.textContent = message;
  msgDiv.style.color = color;
  msgDiv.style.marginTop = "10px";
  msgDiv.style.fontWeight = "bold";
}
