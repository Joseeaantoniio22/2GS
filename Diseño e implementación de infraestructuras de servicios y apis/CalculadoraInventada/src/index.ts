const display = document.getElementById('display') as HTMLInputElement;
const buttons = document.querySelectorAll('button[data-value]');
const clearBtn = document.getElementById('clear')!;
const igualBtn = document.getElementById('igual')!;

let resultado = '';

buttons.forEach(button => {
  button.addEventListener('click', () => {
    const valor = button.getAttribute('data-value');
    if (valor) {
      resultado += valor;
      display.value = resultado;
    }
  });
});

clearBtn.addEventListener('click', () => {
  resultado = '';
  display.value = '';
});

igualBtn.addEventListener('click', () => {
  try {
    // Evalúa la expresión de manera segura
    // NOTA: eval puede ser peligroso, pero aquí se usa para simplificar el ejemplo
    const result = eval(resultado);
    display.value = result;
    resultado = result.toString();
  } catch (error) {
    display.value = 'Error';
    resultado = '';
  }
});
