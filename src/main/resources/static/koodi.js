
function haeKaikki() {
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
                '<li class="row">' + tehtava.id + " " + tehtava.teksti + '</li>' +
            '</ul>'
        );
    }).join('');
}
function generateErrorHTMLOutput(error) {
    return '<h5>Tapahtui virhe!</h5>';
}
document.getElementById('todoInput').addEventListener('submit', performPostRequest);

function performPostRequest(e) {
    var tulosElementti = document.getElementById('tulos2');
    var todoTeksti = document.getElementById('todoTeksti').value;
    tulosElementti.innerHTML = '';

    axios.post('http://localhost:8080/api/todot', {
        teksti: todoTeksti,
    })
        .then(function(response) {
            tulosElementti.innerHTML = 'Loit listalle uuden tehtävän!';
        })
        .catch(function(error) {
            tulosElementti.innerHTML = generateErrorHTMLOutput(error);
        });
    e.preventDefault();
}


function poistaTehtava() {
    var tulosElementti = document.getElementById('tulos3');
    var todoId = document.getElementById('todoId').value;
    tulosElementti.innerHTML = '';

    axios.delete('http://localhost:8080/api/todot/' + todoId, {
        id: todoId,
    })
        .then(function (response) {
            tulosElementti.innerHTML = 'Poistit tehtävän!';
        })
        .catch(function (error) {
            tulosElementti.innerHTML = generateErrorHTMLOutput(error);
        });
}
function clearOutput() {
    var tulosElementti = document.getElementById('tulos1');
    tulosElementti.innerHTML = '';
    var tulosElementti2 = document.getElementById('tulos2');
    tulosElementti2.innerHTML = '';
    var tulosElementti3 = document.getElementById('tulos3');
    tulosElementti3.innerHTML = '';
}