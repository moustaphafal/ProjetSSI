$(document).ready(function() {
    // Ecouteur d'événement pour le formulaire d'inscription
    $('#inscription-form').submit(function(event) {
        event.preventDefault();
        // Récupération des données du formulaire
        var formData = {
        'nom': $('input[name=nom]').val(),
        'prenom': $('input[name=prenom]').val(),
        'email': $('input[name=email]').val(),
        'password': $('input[name=password]').val()
        };
        // Envoi des données au serveur via AJAX
        $.ajax({
        type: 'POST',
        url: 'inscriptionServlet', // Le nom de la servlet doit correspondre à celui de la classe Java
        data: formData,
        dataType: 'json',
        encode: true
        }).done(function(data) {
        console.log(data);
        alert('Inscription réussie !');
        // Redirection vers la page de connexion
        window.location.href = 'connexion.jsp';
        }).fail(function(data) {
        console.log(data);
        alert('Erreur lors de l\'inscription. Veuillez réessayer.');
        });
    });
    });