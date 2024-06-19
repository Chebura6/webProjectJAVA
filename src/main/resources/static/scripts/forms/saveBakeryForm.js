
document.addEventListener("DOMContentLoaded", function submitCreationForm() {
    var form =  document.getElementById("addNewBakeryForm");
    form.addEventListener("submit", async function (event) {
       event.preventDefault();
       var formData = new FormData(form);
       var name = document.getElementById("name").value;
       var description = document.getElementById("description").value;
       var price = document.getElementById("price").value;
       let bakery = {
           "name": name,
           "description": description,
           "price": price
       }

        fetch("pancakes/bakery/save",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(bakery)
        }).then(response => {
            // alert("here");
            response.text().then(data => {

                console.log(data);
                if (response.status === 400) {
                    alert(data);
                } else if (response.status === 200) {
                    alert("Товар успешно добавлен");
                    document.getElementById("addNewBakeryForm").reset();
                    // alert("form must be reset");
                }
            });
        }).catch(error => {
            alert(error);
            alert("Произошла неизвестная ошибка, попробуйте позже");
        });

   })
});