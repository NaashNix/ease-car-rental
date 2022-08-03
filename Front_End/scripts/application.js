const carSelectForm = $("#car-select-form");
const carSelectFormContainer = $("#car-select-form-container");
const basicOrderDetailsForm = $("#basic-order-details-form");
const carSelectContainer = $('#car-select-form');

carSelectContainer.css('display', 'none');
// basicOrderDetailsForm.css('display', 'none');

getAllCarsFromServer();

function getAllCarsFromServer() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/easy-car/app/vehicles",
        // data: "data",
        // dataType: "dataType",
        success: function (response) {

            for (const cars of response.data) {
                addCars(cars);
            }
        }
    });
}

function bindClickEvents() {
    $("#car-select-form-container button").click(function () {

        let id = $(this).parent().find('#car-reference-number').text();
        console.log("ID is : ", id);
        localStorage.setItem('carID', id);
        redirectToPlacingOrderForm();

    });
}

function carViewComponent(car) {

    const carTypeClasses = {
        LUX : 'carTypeLUX',
        GEN : 'carTypeGEN',
        PRM : 'carTypePRM'
    };

    let carTypeOuter = '';

    if (car.carType == 'LUX') {
        console.log(car.carType);
        carTypeOuter = carTypeClasses.LUX;
    }else if (car.carType == 'GEN'){
        carTypeOuter = carTypeClasses.GEN;
    }else {
        carTypeOuter = carTypeClasses.PRM;
    }

    const path = './res/images/sample-image-01.jpeg';
    return `<div class="car-view-outer-div w-25 position-relative">
                    <img src="${path}" alt="">
                    <div style="display:flex; justify-content:center;">
                    <h3 "style="margin-bottom: 0 !important; line-height: 1.5;display:inline !important">${car.brand}</h3>
                    <div id="carTypeContainer" style="display:none;" class="carTypeComponent ${carTypeOuter}">${car.carType}</div>
                    </div>
                    <span>${car.noOfPassengers} Persons | ${car.transmissionType} | ${car.fuelType}</span>
                    <button class="btn btn-dark" type="button">RENT THIS</button>
                    <span style="display:none" id="car-reference-number">${car.carID}</span>
            </div>`;
}

function addCars(cars) {

    console.log(cars);
    carSelectFormContainer.append(carViewComponent(cars));
    bindClickEvents();
}

function redirectToPlacingOrderForm() {
    carSelectForm.addClass('horizTranslate');
    // setTimeout(() => { carSelectForm.css('display', 'none'); }, 700);
    basicOrderDetailsForm.addClass('verticalIntro');
}