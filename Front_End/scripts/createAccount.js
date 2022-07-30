const basicInfoForm = $("#create-account-form-parent");
const imageUploadForm = $("#id-upload-form-parent");
const credentialSettingForm = $("#credential-setting-form");

let x = 0;
if (x == 0) {
    imageUploadForm.css('display', 'none');
    credentialSettingForm.css('display', 'none');
    credentialSettingForm.css('display', 'none');
    x = 1;
}

function loadIdImageUploadPage() {
    basicInfoForm.addClass('horizTranslate');
    setTimeout(() => { basicInfoForm.css('display', 'none'); }, 700);
    imageUploadForm.addClass('verticalIntro');
}

function loadCredentialSettingPage() {
    imageUploadForm.addClass('horizTranslate');
    setTimeout(() => {
        imageUploadForm.css('display', 'none');
        imageUploadForm.removeClass('verticalIntro'); 
        credentialSettingForm.addClass('verticalIntro');
    }, 700);
}

function navigateToMainWebPage(){
    saveCustomerAfterValidation();
}

function getAge(dateString) {
    var today = new Date();
    var birthDate = new Date(dateString);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}


function saveCustomerAfterValidation(){

    // var customerID = '';

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/easy-car/app/customer/lastID",
        // dataType: "application/json",
        success: function (response) {
                // customerID = response.data;
                saveCustomer (response.data);
        },
        error: function (e) {
            console.log(e);

        }
    });

    const saveCustomer = (customerID) => {
        

        let username = $("#username-field").val();
        let password = $("#password-field").val();
        let fullName = $("#full-name-field").val();
        let telephone = $("#telephone-field").val();
        let age = getAge($("#birthday-field").val());
        let address = $("#permanent-address-field").val();
        let email = $("#email-field").val();


        var details = {
            "customerID": customerID,
            "username": username,
            "password": password,
            "fullName": fullName,
            "telephone": telephone,
            "age": age,
            "address": address,
            "email": email
        };

        console.log(details);

        var formBody = [];
        for (var property in details) {
            var encodedKey = encodeURIComponent(property);
            var encodedValue = encodeURIComponent(details[property]);
            formBody.push(encodedKey + "=" + encodedValue);
        }

        formBody = formBody.join("&");


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/easy-car/app/customer",
            data: formBody,
            dataType: "application/x-www-form-urlencoded",
            success: function (response) {
                console.log(response);
            }
        });
    }

    
}

