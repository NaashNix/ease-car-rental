
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
    $("#order-placing-form-container button").click(function () {
        //Get values from the selected row
        let id = $(this).parent().find('span').text();
        // let name = $(this).children().eq(1).text();
        //Set values to the text-fields
        console.log("ID is : ",id);
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
    $("#order-placing-form-container").append(carViewComponent(cars));
    bindClickEvents();
}