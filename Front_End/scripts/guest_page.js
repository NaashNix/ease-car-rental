function loginButtonClicked() {
    const username = $("#userNameField").val();
    const password = $("#passwordField").val();

    if (username == '') {
        $("#userNameField").css('border', '1px solid red');
    } else if (password == '') {
        $("#userNameField").css('border', '');
        $("#passwordField").css('border', '1px solid red');
    } else {
        $("#passwordField").css('border', '');
    }

    redirectToLoginProcess(username, password);

}

var url = 'application.html';
var adminUrl = 'adminDashboard.html';


const redirectToLoginProcess = (username, password) => {



    $.ajax({
        type: "GET",
        url: `http://localhost:8080/easy-car/app/login?username=${username}&password=${password}`,
        data: "",
        success: function(response) {
            console.log(response);


            if (response.data != null) {

                if (response.data.username == 'admin') {
                    localStorage.setItem('userID', response.data.customerID);
                    localStorage.setItem('userName', response.data.fullName);
                    localStorage.setItem('userEmail', response.data.email);
                    localStorage.setItem('userAddress', response.data.address);
                    localStorage.setItem('userTelephone', response.data.telephone);
                    window.location.href = adminUrl;
                } else {

                    localStorage.setItem('userID', response.data.customerID);
                    localStorage.setItem('userName', response.data.fullName);
                    localStorage.setItem('userEmail', response.data.email);
                    localStorage.setItem('userAddress', response.data.address);
                    localStorage.setItem('userTelephone', response.data.telephone);
                    window.location.href = url;
                }
            }
        },
        error: function(er) {
            alert('Server Not Responding.' + er);
        }
    });

    // $(location).attr('href', url);

};


function loadCreateNewAccountPage() {

}