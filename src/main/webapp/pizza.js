function getPizzas(){
    fetch("./api/pizza")
        .then(response => response.json())
        .then(data => {
            let output = "<table style='border-spacing: 15px; padding: 15px'>";
            let count = 0;

            data.forEach(d => {
                output += `<tr><td style="padding: 15px"><img src="${d.picture}"></td><td style="padding: 15px">${d.name}</td><td style="padding: 15px">${d.price}€</td></tr>`;
                count++;
            })

            output += "</table>";
            document.getElementById("Produktliste").innerHTML = output;
        });
}