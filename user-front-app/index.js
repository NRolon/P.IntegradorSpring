const url = 'http://localhost:8080';

const getToken = () => {
    //pedir un token a una api
    //api/v1/auth
    //algo nativo de los browser para hacer peticiones asincronicas
    fetch(`${url}/api/v1/auth`, {
        method: "POST", 
    })
    .then(response => response.json())
    .then(data => console.log(data));
}

const findUsers = () => {
    //pedir un token a una api
    //api/v1/auth
    //algo nativo de los browser para hacer peticiones asincronicas
    fetch(`${url}/user`)
        .then(response => response.json())
        .then(data => console.log(data));
}


const btn = document.getElementById('btn-gettoken');
btn.addEventListener('click',getToken);