const movies = [{
    "_id": "605e57238ed0562b5da2f87c",
    "titulo": "Os Vingadores: Ultimato",
    "sinopse": "Os heróis mais poderosos da Terra enfrentando o Thanos. De novo.",
    "duracao": 181,
    "dataLancamento": new Date("2021-03-27T00:00:00Z"),
    "imagem": "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg",
    "categorias": [
        "Aventura",
        "Ação"
    ]
}, {
    "_id": "605e57238ed0562b5da2f87d",
    "titulo": "Os Vingadores: Guerra Infinita",
    "sinopse": "Os heróis mais poderosos da Terra enfrentando o Thanos",
    "duracao": 149,
    "dataLancamento": new Date("2018-04-26T00:00:00Z"),
    "imagem": "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UX182_CR0,0,182,268_AL_.jpg",
    "categorias": [
        "Aventura",
        "Ação"
    ]
}, {
    "_id": "605e57238ed0562b5da2f87e",
    "titulo": "Os Vingadores: Era de Ultron",
    "sinopse": "Os heróis mais poderosos da Terra enfrentando o Ultron",
    "duracao": 141,
    "dataLancamento": new Date("2015-04-23T00:00:00Z"),
    "imagem": "https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_UX182_CR0,0,182,268_AL_.jpg",
    "categorias": [
        "Aventura",
        "Ação"
    ]
}, {
    "_id": "605e57238ed0562b5da2f87f",
    "titulo": "Os Vingadores",
    "sinopse": "Os heróis mais poderosos da Terra enfrentando o Loki",
    "duracao": 143,
    "dataLancamento": new Date("2012-04-27T00:00:00Z"),
    "imagem": "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg",
    "categorias": [
        "Aventura",
        "Ação"
    ]
}];

async function getAllMovies() {
    return movies;
}

async function getMovieById(id) {
    if (id == -1) return null;

    movies[0]._id = id;
    return movies[0];
}

async function getMoviePremieres() {
    movies[0].dataLancamento = new Date();
    return [movies[0]];
}

async function addMovie(movie) {
    return movies[0];
}

async function deleteMovie(id) {
    if (!id) throw new Error('Não foi possível excluir este filme!');
    return true;
}

module.exports = {
    getAllMovies,
    getMovieById,
    getMoviePremieres,
    addMovie,
    deleteMovie
}