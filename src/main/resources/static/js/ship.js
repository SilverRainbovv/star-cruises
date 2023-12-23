var fields = document.getElementById("fields");

function add(){
    var seatTypeField = document.createElement('input');
    seatTypeField.setAttribute('type', 'text');
    seatTypeField.setAttribute('name', 'seatType');
    seatTypeField.setAttribute('placeholder', 'Seat Type');

    var seatQuantityField = document.createElement('input');
    seatQuantityField.setAttribute('type', 'number');
    seatQuantityField.setAttribute('name', 'seatNumber');
    seatQuantityField.setAttribute('placeholder', 'Seats Number');

    var seatPriceField = document.createElement('input');
    seatPriceField.setAttribute('type', 'number');
    seatPriceField.setAttribute('name', 'seatPrice');
    seatPriceField.setAttribute('placeholder', 'Seat Price');

    fields.appendChild(seatTypeField);
    fields.appendChild(seatQuantityField);
    fields.appendChild(seatPriceField);

}