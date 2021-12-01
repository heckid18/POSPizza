function getPizzas(){
    fetch("./api/pizza")
        .then(response => response.json())
        .then(data => {
            let output = "<table>";
            let count = 0;

            data.forEach(d => {
                output += `<tr><td><img src="${d.picture}"</td><td>${d.name}</td><td>${d.price}</td></tr>`;
                count++;
            })
        });
}