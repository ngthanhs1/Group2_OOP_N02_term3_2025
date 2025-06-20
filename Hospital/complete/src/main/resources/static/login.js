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
      alert(data.message);
      window.location.href = "dashboard.html";
    } else {
      showMessage(data.message, "red");
    }
  })
  .catch(error => {
    console.error("Lỗi kết nối:", error);
    showMessage("Không thể kết nối đến server.", "red");
  });
}
