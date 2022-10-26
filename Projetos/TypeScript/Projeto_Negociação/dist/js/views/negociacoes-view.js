import { View } from "./view.js";
export class NegociacoesView extends View {
    template(model) {
        return `
        <table class="table table-hover table-bored">
          <thead>
            <tr>
              <th>Data</th>
              <th>Quantidade</th>
              <th>valor</th>
            </tr>
          </thead>
          <tbody>
            ${model.lista().map(negociacao => {
            return `
                  <tr>
                    <td>${this.conversorData(negociacao.data)}</td>
                    <td>${negociacao.quantidade}</td>
                    <td>${negociacao.valor}</td>
                  </tr>
                `;
        }).join('')}
          </tbody>
        </table>
      `;
    }
    update(model) {
        const template = this.template(model);
        this.elemento.innerHTML = template;
    }
    conversorData(data) {
        return new Intl.DateTimeFormat().format(data);
    }
}
