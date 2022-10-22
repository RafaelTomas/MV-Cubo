export class NegociacoesView {
    constructor(seletor) {
        this.elemento = document.querySelector(seletor);
    }
    template() {
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
          </tbody>
        </table>
      `;
    }
    update() {
        this.elemento.innerHTML = this.template();
    }
}
