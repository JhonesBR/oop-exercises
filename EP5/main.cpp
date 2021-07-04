#include <iostream>
#include <list>

class Carro{
public:
    // Construtor
    Carro(int velocidadeMaxima, float capacidadeTanque) : velocidadeMaxima(velocidadeMaxima), capacidadeTanque(capacidadeTanque) {}

    // Função para mostrar o painel
    void showPainel(){
        if (this->gasolina <= 0){
            this->velocidade = 0;
            this->rpm = 0;
            this->countProblema += 1;
            this->problemas[10] = true;
        } else{
            this->countProblema -= 1;
            this->problemas[10] = false;
        }
        std::cout << "\n\n\n\n\n\n\n\n" << std::endl;
        std::cout << "Velocidade: " << this->velocidade << std::endl;
        std::cout << "RPM: " << this->rpm << std::endl;
        std::cout << "Tanque: " << (this->gasolina/this->capacidadeTanque)*100 << "% (" << this->gasolina << "L)" <<std::endl;
        if (this->countProblema > 0){
            std::cout << "Problemas:" << std::endl;
            this->listarProblemas();
        }
    }

    // Função para listar problemas
    void listarProblemas(){
        if (this->problemas[10] == true){
            std::cout << "\tSem gasolina" << std::endl;
        }
        if (this->problemas[0] == true){
            std::cout << "\tSistema de ignicao danificado" << std::endl;
        }
        if (this->problemas[1] == true){
            std::cout << "\tABS danificado" << std::endl;
        }
        if (this->problemas[2] == true){
            std::cout << "\tAirbag não operacional" << std::endl;
        }
        if (this->problemas[3] == true){
            std::cout << "\tPneu descalibrado" << std::endl;
        }
        if (this->problemas[4] == true){
            std::cout << "\tOleo do motor em quantidade errada" << std::endl;
        }
        if (this->problemas[5] == true){
            std::cout << "\tBateria danificada" << std::endl;
        }
        if (this->problemas[6] == true){
            std::cout << "\tControle de Cruzeiro Adaptativo nao operacional" << std::endl;
        }
        if (this->problemas[7] == true){
            std::cout << "\tCambio danificado" << std::endl;
        }
        if (this->problemas[8] == true){
            std::cout << "\tCentral eletronica danificada" << std::endl;
        }
        if (this->problemas[9] == true){
            std::cout << "\tDirecao eletrica danificada" << std::endl;
        }

    }

    // Função para "gerar problema"
    void quebrar(int n){
        if (n >= 1 && n <= 10){
            if (this->problemas[n-1] == false){
                this->problemas[n-1] = true;
                this->countProblema += 1;
            }
        }
    }

    // Função para "arrumar problema"
    void arrumar(int n){
        if (n >= 1 && n <= 10){
            if (this->problemas[n-1] == true){
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
        // O tanque nao ficara menos que vazio
        std::cout << q << std::endl;
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
        if (velocidade >= 0 && velocidade < M[0]){ // Primeira marcha
            pMenor = 0;
            pMaior = M[0];
        } else if (velocidade >= M[0] && velocidade < M[1]){ // Segunda marcha
            pMenor = M[0];
            pMaior = M[1];
        } else if (velocidade >= M[1] && velocidade < M[2]){ // Terceira marcha
            pMenor = M[1];
            pMaior = M[2];
        } else if (velocidade >= M[2] && velocidade < M[3]){ // Quarta marcha
            pMenor = M[2];
            pMaior = M[3];
        } else if (velocidade >= M[3] && velocidade < M[4]){ // Quinta marcha
            pMenor = M[3];
            pMaior = M[4];
        } else if (velocidade >= M[4]){ // Sexta marcha
            pMenor = M[4];
            pMaior = this->velocidadeMaxima;
        }
        this->rpm = ((1100*(velocidade-pMenor))+(1500*(pMenor-pMaior)))/(pMaior-pMenor);
    }

    // Função para inicializar a variavel problemas
    void initProblemas(){
        for (int i=0; i<10; i++){
            this->problemas[i] = false;
        }
        problemas[10] = true;
    }

private:
    int velocidade = 0;
    int velocidadeMaxima;
    float gasolina = 0;
    float capacidadeTanque;
    int rpm = 0;
    int countProblema = 0;

    // problemas[0] = Sistema de ignicao danificado
    // problemas[1] = ABS danificado
    // problemas[2] = Airbag não operacional
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
    Carro carro(200, 50);
    carro.initProblemas();
    int opc = -1;
    int opc2 = -1;
    int v;
    float q;
    while (opc != 7){
        carro.showPainel();

        std::cout << "(1) Acelerar  (3) Abastecer     (5) Concertar" << std::endl;
        std::cout << "(2) Freiar    (4) Desabastecer  (6) Quebrar"<< std::endl;
        std::cout << "              (7) Desligar" << std::endl << ">> ";
        std::cin >> opc;

        switch (opc){
            case 1:
                std::cout << "Insira a velocidade a acelerar em Km/h: " << std::endl;
                std::cin >> v;
                carro.mudarVelocidade(v);
                break;

            case 2:
                std::cout << "Insira a velocidade a freiar em Km/h: " << std::endl;
                std::cin >> v;
                carro.mudarVelocidade(-v);
                break;

            case 3:
                std::cout << "Insira a quantidade a abastecer em L: " << std::endl;
                std::cin >> q;
                carro.abastecer(q);
                break;

            case 4:
                std::cout << "Insira a quantidade a desabastecer em L: " << std::endl;
                std::cin >> q;
                carro.abastecer(-q);
                break;

            case 5:
                std::cout << "Selecione a opcao para concertar: " << std::endl;
                std::cout << "(1) Injecao eletronica   (2) ABS" << std::endl;
                std::cout << "(3) Airbag               (4) Pneu" << std::endl;
                std::cout << "(5) Oleo do motor        (6) Bateria" << std::endl;
                std::cout << "(7) Cruzeiro Adaptativo  (8) Cambio" << std::endl;
                std::cout << "(9) Central eletronica   (10) Direcao" << std::endl << ">> ";
                std::cin >> opc2;
                carro.arrumar(opc2);
                break;

            case 6:
                std::cout << "Selecione a opcao para quebrar: " << std::endl;
                std::cout << "(1) Injecao eletronica   (2) ABS" << std::endl;
                std::cout << "(3) Airbag               (4) Pneu" << std::endl;
                std::cout << "(5) Oleo do motor        (6) Bateria" << std::endl;
                std::cout << "(7) Cruzeiro Adaptativo  (8) Cambio" << std::endl;
                std::cout << "(9) Central eletronica   (10) Direcao" << std::endl << ">> ";
                std::cin >> opc2;
                carro.quebrar(opc2);
                break;

        }
    }
    return 0;
}