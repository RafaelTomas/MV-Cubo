import { Negociacoes } from "../models/negociacoes.js";
import { View } from "./view.js";
export class NegociacoesView extends View<Negociacoes> {

   protected template(model: Negociacoes): string {
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

  update(model: Negociacoes): void {
    const template = this.template(model);
    this.elemento.innerHTML = template;
  }

   private conversorData(data: Date): string {
    return new Intl.DateTimeFormat().format(data);
  }
}