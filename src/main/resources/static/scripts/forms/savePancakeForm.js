
document.addEventListener("DOMContentLoaded", function submitCreationForm() {
    var form =  document.getElementById("addNewPancakeForm");
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        var formData = new FormData(form);
        var name = document.getElementById("name").value;
        var description = document.getElementById("description").value;
        var price = document.getElementById("price").value;

        let pancake = {
            "name" : name,
            "description" : description,
            "price" : price
        }

        fetch("pancakes/pancake/save",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(pancake)
        }).then(response => {
            // alert("here");
            response.text().then(data => {

                console.log(data);
                if (response.status === 400) {
                    alert(data);
                } else if (response.status === 200) {
                    alert("Товар успешно добавлен");
                    document.getElementById("addNewPancakeForm").reset();
                }
            });
        }).catch(error => {
            alert(error);
            alert("Произошла неизвестная ошибка, попробуйте позже");
        });
    })
})