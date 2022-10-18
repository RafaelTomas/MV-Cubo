const {test, expect} = require('@jest/globals');
const repository = require('./repository')

let movieId = null;

beforeAll(async () => {
  const movies = await repository.getAllMovies();
  movieId = movies[0]._id;
})

test('Get All Movies', async () => {
  const movie = await repository.getAllMovies();
  expect(Array.isArray(movie)).toBeTruthy();
  expect(movie.length).toBeTruthy();
})

test('Get movies by id', async () => {
  const movie = await repository.getMovieById(movieId);
  expect(movie).toBeTruthy();
  expect(movie._id).toEqual(movieId);
} )

test('Get movie premier', async () => {
  const monthAgo = new Date();
  monthAgo.setMonth(-1);

  const movie = await repository.getMoviePremieres();
  expect(Array.isArray(movie)).toBeTruthy();
  expect(movie.length).toBeTruthy();
  expect(movie[0].dataLancamento.getTime()).toBeGreaterThanOrEqual(monthAgo.getTime());;
} )

test('addMovie', async () => {
    const movie = {
        titulo: 'Test Movie',
        sinopse: 'Movie Summary',
        duracao: 120,
        dataLancamento: new Date(),
        imagem: 'image.jpg',
        categorias: ['Aventura']
    };

    let result;

    try {
        result = await repository.addMovie(movie);
        expect(result).toBeTruthy();
    } finally {
        if (result)
            await repository.deleteMovie(result._id);
    }
})

test('deleteMovie', async () => {
    const movie = {
        titulo: 'Test Movie',
        sinopse: 'Movie Summary',
        duracao: 120,
        dataLancamento: new Date(),
        imagem: 'image.jpg',
        categorias: ['Aventura']
    };

    const result = await repository.addMovie(movie);
    const result2 = await repository.deleteMovie(result._id);
    expect(result2).toBeTruthy();
})