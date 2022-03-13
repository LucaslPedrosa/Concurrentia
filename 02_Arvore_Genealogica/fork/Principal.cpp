
#include <unistd.h>
#include <iostream>
#include <time.h>


int main()
{
    pid_t idProcesso;
    std::cout << "Inicio da humanidade\n";
    
    // TIME 0
    // BEGINNING OF HUMANITY
    

        
    std::cout << "Nasce o pai, ID do pai: " << getpid() << '\n';
    
    sleep(22); //Pai envelhece 22 anos, tendo agora 22
    
    idProcesso = fork(); // Nasce o primeiro filho
    
    if(idProcesso == -1) // Nao de erro por favor
        exit(1);
    
    
    // If para verificar se e do pai ou do filho
    
    // no c++ tudo que for diferente de 0 retornara true no if statement
    // entao nao ha necessidade de realizar comparacoes
    
    if(idProcesso){
        sleep(3); // Pai envelhece 3 anos tendo agora 25
        idProcesso = fork(); // Outro filho o homem e uma maquina
        
        if(idProcesso == -1)
            exit(1);
        
        
        if(idProcesso){
            sleep(7); // o pai envelhece 7 anos tendo agora 32 anos
            
            idProcesso = fork(); // terceiro filho do pai
            if(idProcesso == -1)
                exit(1);
                
            if(idProcesso){
                
                sleep(58); // o pai envelhece 48 anos
                std::cout << "O pai morre aos 90 anos\n";
                _Exit(0);
                
                
            }else{
                std::cout << "Nasce o filho 3, ID do pai: " << getppid() << " ID do filho: " << getpid() << '\n';
                sleep(55);// filho envelhece 55 anos
                std::cout << "O terceiro filho morre aos 55 anos\n";
                _Exit(0);
            }
            
        }else{
            std::cout << "Nasce o filho dois, ID do pai: " << getppid() << " ID do filho: " << getpid() << '\n';
            sleep(20); // Segundo filho envelhece 20 anos
            
            idProcesso = fork(); // nasce neto 2
            if(idProcesso == -1)
                exit(1);
            if(idProcesso){
                sleep(35); // filho 2 envelhece 35 anos
                std::cout << "Morre o segundo filho aos 55 anos\n";
                _Exit(0);
            }else{
                std::cout << "Nasce o segundo neto, ID do pai: " << getppid() << " ID do filho: " << getpid() << '\n';
                sleep(33); // neto 2 envelhece 33 anos
                std::cout << "O segundo neto morre aos 33 anos\n";
                _Exit(0);
            }
            
        }
        
        
    }
    else{
        std::cout << "O pai tem o primeiro filho aos 22 anos, ID do filho: " << getpid() << " ID do pai: " << getppid() << '\n';
        sleep(16); // primeiro filho envelhece 16 anos
        idProcesso = fork(); // primeiro filho tem primeiro filho
        
        if(idProcesso == -1)
            exit(1);
            
        if(idProcesso){
            
            sleep(45); // primeiro filho envelhece 45 anos
            std::cout << "primeiro filho morre aos 61 anos\n";
            _Exit(0);
            
        }else{
            std::cout << "nasce o neto 1, ID do pai: " << getppid() << " ID do filho: " << getpid() << '\n';
            sleep(30); // neto 1 envelhece 30 anos
            
            idProcesso = fork(); // nasce o bisneto 1
            
            if(idProcesso == -1){
                exit(1);
            }
            
            if(idProcesso){
                sleep(5);
                std::cout << "O primeiro neto morre aos 35 anos\n";
                _Exit(0);
                
            }else
            {
                std::cout << "Nasce o bisneto 1, ID do pai: " << getppid() << " ID do filho: " << getpid() << '\n';
                sleep(12); // bisneto envelhece 12 anos
                std::cout << "O bisneto morre aos 12 anos\n";
                _Exit(0);
                
            }
            
        }
        

    }
        
    return 0;
}
