function loginButtonClicked() {
    const username = $("#userNameField").val();
    const password =  $("#passwordField").val();

    if (username == '') {
        $("#userNameField").css('border','1px solid red');
    }else if (password == ''){
        $("#userNameField").css('border', '');
        $("#passwordField").css('border', '1px solid red');
    }else{
        $("#passwordField").css('border', '');
    }

    redirectToLoginProcess(username,password);

}

const redirectToLoginProcess = (username,password) => {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/easy-car/app/login?username=${username}&password=${password}`,
        data: "",
        success: function (response) {
            console.log(response);
            if  (response.data != null){
                window.location.href = "/application.html";
            }
            // redirect to the place order form.
        }
    });
}


function loadCreateNewAccountPage() {
    
}