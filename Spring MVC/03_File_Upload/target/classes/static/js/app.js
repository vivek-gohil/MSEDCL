// Show selected file name
function showFileName(input) {
    const fileName = input.files[0]?.name;
    if (fileName) {
        document.getElementById("fileName").innerText = fileName;
    }
}

// Validate before upload
function validateForm() {
    const fileInput = document.getElementById("file");
    if (!fileInput.value) {
        alert("Please select a file!");
        return false; // stop submit
    }
    return true;
}