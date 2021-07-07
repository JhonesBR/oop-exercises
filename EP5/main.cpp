#include <iostream>

using namespace std;

class Carro{
public:
    // Construtor
    Carro(int velocidadeMaxima, float capacidadeTanque) : velocidadeMaxima(velocidadeMaxima), capacidadeTanque(capacidadeTanque) {}

    // Função para mostrar o painel
    void showPainel(){
        if (this->gasolina <= 0){
            this->velocidade = 0;
            this->rpm = 0;
            if (!this->problemas[10]){
                this->countProblema += 1;
                this->problemas[10] = true;
            }
        } else{
            if (this->problemas[10]){
                this->countProblema -= 1;
                this->problemas[10] = false;
            }
        }
        cout << "\n\n\n\n\n\n\n\n" << endl;
        cout << "Velocidade: " << this->velocidade << endl;
        cout << "RPM: " << this->rpm << endl;
        cout << "Marcha: " << this->marcha << endl;
        cout << "Tanque: " << (this->gasolina/this->capacidadeTanque)*100 << "% (" << this->gasolina << "L)" <<endl;
        if (this->countProblema > 0){
            cout << "Problemas:" << endl;
            this->listarProblemas();
        }
    }

    // Função para listar problemas
    void listarProblemas(){
        if (this->problemas[10]){
            cout << "\tSem gasolina" << endl;
        }
        if (this->problemas[0]){
            cout << "\tSistema de ignicao danificado" << endl;
        }
        if (this->problemas[1]){
            cout << "\tABS danificado" << endl;
        }
        if (this->problemas[2]){
            cout << "\tAirbag nao operacional" << endl;
        }
        if (this->problemas[3]){
            cout << "\tPneu descalibrado" << endl;
        }
        if (this->problemas[4]){
            cout << "\tOleo do motor em quantidade errada" << endl;
        }
        if (this->problemas[5]){
            cout << "\tBateria danificada" << endl;
        }
        if (this->problemas[6]){
            cout << "\tControle de Cruzeiro Adaptativo nao operacional" << endl;
        }
        if (this->problemas[7]){
            cout << "\tCambio danificado" << endl;
        }
        if (this->problemas[8]){
            cout << "\tCentral eletronica danificada" << endl;
        }
        if (this->problemas[9]){
            cout << "\tDirecao eletrica danificada" << endl;
        }

    }

    // Função para "gerar problema"
    void quebrar(int n){
        cout << n << endl;
        if (n >= 1 && n <= 10){
            if (!this->problemas[n-1]){
                this->problemas[n-1] = true;
                this->countProblema += 1;
            }
        }
    }

    // Função para "arrumar problema"
    void arrumar(int n){
        if (n >= 1 && n <= 10){
            if (this->problemas[n-1]){
                this->problemas[n-1] = false;
                this->countProblema -= 1;
            }
        }
    }

    // Função para mudar a velocidade do carro
    void mudarVelocidade(int V){
        // A nova velocidade será maior que 0
        if (this->velocidade + V > 0){
            // A nova velocidade será menor que a velocidade máxima
            if (this->velocidade + V < this->velocidadeMaxima){
                this->velocidade += V;
            } else {
                this->velocidade = this->velocidadeMaxima;
            }
        } else{
            this->velocidade = 0;
        }
        this->setRPM();
    }

    // Função para abastecer e desabastecer
    void abastecer(float q){
        // Manipula o controle de falta de gasolina
        if (this->gasolina == 0 && this->countProblema-1 > 0 && q > 0){
            this->countProblema -= 1;
            this->problemas[10] = false;
        }
        // O tanque nao ficara menos que vazio
        cout << q << endl;
        if (this->gasolina + q > 0){
            // O tanque nao passara do limite
            if (this->gasolina + q < this->capacidadeTanque){
                this->gasolina += q;
            } else {
                this->gasolina = this->capacidadeTanque;
            }
        } else{
            this->gasolina = 0;
        }
    }

    // Função para definir o RPM
    void setRPM(){
        int M[5];
        M[2] = this->velocidadeMaxima/2;
        M[1] = M[2]/2;
        M[0] = M[1]/2;
        M[3] = M[2] + M[0];
        M[4] = M[3] + M[0];

        int velocidade = this->velocidade;
        int pMenor, pMaior;
        pMenor = pMaior = 0;
        if (velocidade >= 0 && velocidade < M[0]){ // Primeira marcha
            pMenor = 0;
            pMaior = M[0];
            this->marcha = 1;
        } else if (velocidade >= M[0] && velocidade < M[1]){ // Segunda marcha
            pMenor = M[0];
            pMaior = M[1];
            this->marcha = 2;
        } else if (velocidade >= M[1] && velocidade < M[2]){ // Terceira marcha
            pMenor = M[1];
            pMaior = M[2];
            this->marcha = 3;
        } else if (velocidade >= M[2] && velocidade < M[3]){ // Quarta marcha
            pMenor = M[2];
            pMaior = M[3];
            this->marcha = 4;
        } else if (velocidade >= M[3] && velocidade < M[4]){ // Quinta marcha
            pMenor = M[3];
            pMaior = M[4];
            this->marcha = 5;
        } else if (velocidade >= M[4]){ // Sexta marcha
            pMenor = M[4];
            pMaior = this->velocidadeMaxima;
            this->marcha = 6;
        }
        this->rpm = ((1100*(velocidade-pMenor))-(1500*(pMenor-pMaior)))/(pMaior-pMenor);
    }

    // Função para inicializar a variavel problemas
    void initProblemas(){
        for (int i=0; i<11; i++){
            this->problemas[i] = false;
        }
    }

private:
    int velocidade = 0;
    int velocidadeMaxima;
    float gasolina = 0;
    float capacidadeTanque;
    int rpm = 0;
    int countProblema = 0;
    int marcha = 0;

    // problemas[0] = Sistema de ignicao danificado
    // problemas[1] = ABS danificado
    // problemas[2] = Airbag nao operacional
    // problemas[3] = Pneu descalibrado
    // problemas[4] = Oleo do motor em quantidade errada
    // problemas[5] = Bateria danificada
    // problemas[6] = Controle de Cruzeiro Adaptativo nao operacional
    // problemas[7] = Cambio danificado
    // problemas[8] = Central eletronica danificada
    // problemas[9] = Direcao eletrica danificada
    // problemas[10] = Sem gasolina
    bool problemas[11];
};

int main() {
    // Declarando o objeto
    Carro carro(200, 50);
    carro.initProblemas();

    // Declaração de variáveis
    int opc = -1;
    int opc2 = -1;
    int v;
    float q;

    // Menu
    while (opc != 7){
        carro.showPainel();

        cout << "(1) Acelerar  (3) Abastecer     (5) Concertar" << endl;
        cout << "(2) Freiar    (4) Desabastecer  (6) Quebrar"<< endl;
        cout << "              (7) Desligar" << endl << ">> ";
        cin >> opc;

        switch (opc){
            case 1:
                cout << "Insira a velocidade a acelerar em Km/h: " << endl;
                cin >> v;
                carro.mudarVelocidade(v);
                break;

            case 2:
                cout << "Insira a velocidade a freiar em Km/h: " << endl;
                cin >> v;
                carro.mudarVelocidade(-v);
                break;

            case 3:
                cout << "Insira a quantidade a abastecer em L: " << endl;
                cin >> q;
                carro.abastecer(q);
                break;

            case 4:
                cout << "Insira a quantidade a desabastecer em L: " << endl;
                cin >> q;
                carro.abastecer(-q);
                break;

            case 5:
                cout << "Selecione a opcao para concertar: " << endl;
                cout << "(1) Injecao eletronica   (2) ABS" << endl;
                cout << "(3) Airbag               (4) Pneu" << endl;
                cout << "(5) Oleo do motor        (6) Bateria" << endl;
                cout << "(7) Cruzeiro Adaptativo  (8) Cambio" << endl;
                cout << "(9) Central eletronica   (10) Direcao" << endl << ">> ";
                cin >> opc2;
                carro.arrumar(opc2);
                break;

            case 6:
                cout << "Selecione a opcao para quebrar: " << endl;
                cout << "(1) Injecao eletronica   (2) ABS" << endl;
                cout << "(3) Airbag               (4) Pneu" << endl;
                cout << "(5) Oleo do motor        (6) Bateria" << endl;
                cout << "(7) Cruzeiro Adaptativo  (8) Cambio" << endl;
                cout << "(9) Central eletronica   (10) Direcao" << endl << ">> ";
                cin >> opc2;
                carro.quebrar(opc2);
                break;
        }
    }
    return 0;
}