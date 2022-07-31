const carSelectForm = $("#car-select-form");
const carSelectFormContainer = $("#car-select-form-container");
const basicOrderDetailsForm = $("#basic-order-details-form");

basicOrderDetailsForm.css('display','none');

getAllCarsFromServer();

function getAllCarsFromServer() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/easy-car/app/vehicles",
        // data: "data",
        // dataType: "dataType",
        success: function (response) {
            
            for (const cars of response.data){
                addCars(cars);
            }
        }
    });
}

function bindClickEvents() {
    $( carSelectFormContainer,"button").click(function () {
        
        let id = $(this).parent().find('#car-reference-number').text();
        console.log("ID is : ",id);
        localStorage.setItem('carID', id);
        redirectToPlacingOrderForm();

    });
}

function carViewComponent(car) {
    const path = './res/images/sample-image-01.jpeg';
    return `<div class="car-view-outer-div w-25">
                    <img src="${path}" alt="">
                    <h3 style="margin-bottom: 0 !important;">${car.brand}</h3>
                    <span>${car.noOfPassengers} Persons | ${car.carType} | ${car.fuelType}</span>
                    <button class="btn btn-dark" type="button">RENT THIS</button>
                    <span style="display:none" id="car-reference-number">${car.carID}</span>
            </div>`;
}

function addCars(cars) {

    console.log(cars);
    carSelectFormContainer.append(carViewComponent(cars));
    
    bindClickEvents();
}

function redirectToPlacingOrderForm(){
    carSelectForm.addClass('horizTranslate');
    // setTimeout(() => { carSelectForm.css('display', 'none'); }, 700);
    basicOrderDetailsForm.addClass('verticalIntro');
}