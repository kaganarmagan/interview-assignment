$(document).ready(function () {

    $("#dropCityButton").click(function (event) {

        event.preventDefault();

        var myArray = []
        const city = {};
        city["request"]= $('#dropCity :selected').val();

        function buildTable(data){
            var table = document.getElementById('myTable')
            table.innerHTML = "";
            for (var i = 0; i < data.length; i++){
                var row = `<tr th:each="customer: ${data}">
							<td>${data[i].id}</td>
						    <td>${data[i].name}</td>
						    <td>${data[i].trId}</td>
							<td>${data[i].birthDate}</td>
							<td>${data[i].email}</td>
							<td>${data[i].phone}</td>							
							<td>${data[i].city}</td>
							<td>${data[i].itemsQuant}</td>
							<td><a href="/item/${data[i].id}" class="btn btn-secondary"><i class="fas fa-dolly"></i></a></td>
							<td><a href="/update/${data[i].id}" class="btn btn-primary"><i class="fas fa-user-edit"></i></a></td>
							<td><a href="/delete/${data[i].id}" class="btn btn-danger"><i class="fa fa-user-times"></i></a></td>

					  </tr>`
                table.innerHTML += row


            }
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/city",
            data: JSON.stringify(city),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {


                buildTable(data)

            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });

    });

});