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