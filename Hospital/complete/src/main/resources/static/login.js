function login() {
  const username = document.getElementById("username").value.trim();
  const password = document.getElementById("password").value;

  fetch("/api/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password })
  })
    .then(res => res.json())
    .then(data => {
      if (data.success) {
        // Lưu user vào localStorage
        localStorage.setItem("currentUser", JSON.stringify({ username: data.username }));

        // Chuyển sang dashboard
        window.location.href = "dashboard.html";
      } else {
        showMessage(data.message, "red");
      }
    })
    .catch(error => {
      console.error("Lỗi:", error);
      showMessage("Không thể kết nối đến server.", "red");
    });
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
