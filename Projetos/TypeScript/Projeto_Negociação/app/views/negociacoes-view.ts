export class NegociacoesView {

  private elemento: HTMLElement;

  constructor(seletor: string){
    this.elemento = document.querySelector(seletor);
  }
    template(): string {
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

    update(): void{
      this.elemento.innerHTML = this.template();
    }
}