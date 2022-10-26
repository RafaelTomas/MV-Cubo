import { NegociacaoController } from './controllers/negociacao-controller.js';
import { NegociacoesView } from './views/negociacoes-view.js';

const controller = new NegociacaoController();
const form = document.querySelector('.form');
if(form){
    form.addEventListener('submit', event => {
        event.preventDefault();
        controller.adiciona();
    });
} else {
    throw Error('Não foi possivel começar a aplicação verifique se o form existe')
}

// const negociacoesView = new NegociacoesView()
// const template = negociacoesView.template();
// console.log(template);