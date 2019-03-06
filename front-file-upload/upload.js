const baseUrl = 'http://localhost:8080/';
const form = document.querySelector('form');

form.addEventListener('submit', e => {
    e.preventDefault();

    const files = document.querySelector('[type=file]').files;
    if(files.length == 0){
      console.error("No files to upload");
      return;
    }

    const formData = new FormData();

    for (let i = 0; i < files.length; i++) {
        formData.append('file' + (files.length > 1 ? 's' : ''), files[i]);
    }

    var url = baseUrl + (files.length > 1 ? "uploadMultipleFiles" : "uploadFile");

    fetch(url,{
        method: 'POST',
        body: formData
    }).then(function(response){
      if(response.ok)
        console.log("File uploaded sucessfully.");
      else
        console.error("An error " + response.status + " occured...");
    });
});
