$(document).ready(function () {

    $("#dropCityButton").click(function (event) {

        event.preventDefault();

        const city = {};
        city["request"]= $('#dropCity :selected').val();


        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/city",
            data: JSON.stringify(city),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "Ajax Cevap"
                    + JSON.stringify(data, null, 4);
                $('#feedback').html(json);

            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });

    });

});