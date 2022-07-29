const basicInfoForm = $("#create-account-form-parent");
const imageUploadForm = $("#id-upload-form-parent");


imageUploadForm.css('display', 'none');

 

function loadIdImageUploadPage () {
    basicInfoForm.addClass('horizTranslate');
    setTimeout(() => {basicInfoForm.css ('display','none')}, 700);
    imageUploadForm.addClass('verticalIntro');
}