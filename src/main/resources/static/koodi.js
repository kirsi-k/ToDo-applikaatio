
function haeKaikki() {
    console.log("nappi toimii")
    var tulosElementti = document.getElementById('tulos1');
    tulosElementti.innerHTML = '';

    axios.get('http://localhost:8080/api/todot')
        .then(function (response) {
            tulosElementti.innerHTML = generateSuccessHTMLOutput(response);
        })
        .catch(function (error) {
            tulosElementti.innerHTML = generateErrorHTMLOutput(error);
        });
}
function generateSuccessHTMLOutput(response){
    return response.data.map(function (tehtava) {
        return (
            '<ul class="list-unstyled">' +
                '<li class="row">' + tehtava.teksti + '</li>' +
            '</ul>'
        );
    }).join('');
}
function generateErrorHTMLOutput(error) {
    return '<h5>Tapahtui virhe!</h5>';
}
