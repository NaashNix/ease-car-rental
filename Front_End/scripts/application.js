const carSelectForm = $("#car-select-form");
const carSelectFormContainer = $("#car-select-form-container");
const basicOrderDetailsForm = $("#basic-order-details-form");
const carSelectContainer = $('#car-select-form');
const customerNameField = $('#customer-name-field');
const customerAddressField = $('#customer-address-field');
const customerEmailField = $('#customer-email-field');
const customerTelephoneField = $('#customer-telephone-field');
const carNameField = $('#car-name-field');
const passengerCountField = $('#passenger-count-field');
const gearTypeField = $('#gear-type-field');
const carTypeField = $('#car-type-field');
const fuelTypeField = $('#fuel-type-field');
const carColorField = $('#car-color-field');



// carSelectContainer.css('display', 'none');
basicOrderDetailsForm.css('display', 'none');




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
        console.log('bindClickEvents()');
        let x = 0;
        let id = $(this).parent().find('#car-reference-number').text();
        localStorage.setItem('carID', id);

        if (x == 0) {
            x = 1;
            redirectToPlacingOrderForm();
        }
    });
    
}

function carViewComponent(car) {

    console.log('carViewComponent(car)');

    const carTypeClasses = {
        LUX: 'carTypeLUX',
        GEN: 'carTypeGEN',
        PRM: 'carTypePRM'
    };

    let carTypeOuter = '';

    if (car.carType == 'LUX') {
        carTypeOuter = carTypeClasses.LUX;
    } else if (car.carType == 'GEN') {
        carTypeOuter = carTypeClasses.GEN;
    } else {
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

    console.log('addCars ()');
    carSelectFormContainer.append(carViewComponent(cars));
    bindClickEvents();
    
}

function redirectToPlacingOrderForm() {
    console.log('redirectToPlacingOrderForm()');
    carSelectForm.addClass('horizTranslate');
    // setTimeout(() => { carSelectForm.css('display', 'none'); }, 700);
    basicOrderDetailsForm.addClass('verticalIntro');
    placingOrderFormFlow();
}

function placingOrderFormFlow() {
    // loadCarDetailsToTheForm();
    console.log('placingOrderFormFlow()');
    setDataToCustomerDetailsForm();
}

function setDataToCustomerDetailsForm() {
    $('#car-rate-table').empty();
    customerNameField.text(localStorage.getItem('userName'));
    customerAddressField.text(localStorage.getItem('userAddress'));
    customerEmailField.text(localStorage.getItem('userEmail'));
    customerTelephoneField.text(localStorage.getItem('userTelephone'));
    console.log('loadCarDetailsToTheForm');
    // debugger;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/easy-car/app/vehicles/${localStorage.getItem('carID')}`,
        success: function (response) {
            localStorage.removeItem('carID');
            console.log(response.data.brand);
            carNameField.text(response.data.brand);
            carTypeField.text(response.data.carType);
            gearTypeField.text(response.data.transmissionType);
            carColorField.text(response.data.color);
            fuelTypeField.text(response.data.fuelType);
            passengerCountField.text(response.data.noOfPassengers + ' Persons');
            $('#car-rate-table').empty();
            setDataToRateTable('Daily', response.data.dailyRate, '30 Days');
            setDataToRateTable('Monthly', response.data.monthlyRate, '30 Days');
            $('#car-rate-table').append(
                `<tr><td colspan='3'> Price For Extra - Rs. ${4500.00} /Km</td></tr>`
            );

        }
    });
}


function loadCarDetailsToTheForm() {

}

function setDataToRateTable(package, rate, time) {
    
    let row = `<tr><td>${package}</td><td>Rs. ${rate}</td><td>${time}</td></tr>`;
    $('#car-rate-table').append(row);
}