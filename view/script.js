$(document).ready(function() {
    $.ajax({
        url: "http://localhost:9001/person"
    }).then(function(data) {
        $.each( data, function(i,value){
            console.log(value);
           $('.data').append("<li>" + value.fullName + "</li>");
        });
    });
});