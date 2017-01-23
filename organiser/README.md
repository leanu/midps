*This is raw task for future app*
#Tema: Organiser Mobile Application (DAILY PLANNER)

##Scopul lucrării de laborator
De realizat aplicație tip Organiser pe platforma aleasă.
La formarea și proiectarea aplicațiilor sunt introduse puncte stricte,
ce sunt obligatorii de respectat. La discreția personală rămâne designul aplicației
și API-ul/Framework-ul în care va fi dezvoltată lucrarea de laborator #2. Componentele și 
structura fiecărei Activități va fi descrisă mai jos.

###UI Components
Aplicația va conține minim 3 Activități de baza care vor fi numerotate în lucrare sub forma:

1. MainActivity (structura/componente)
  * Calendar View (custom or default)
  * Buttons (Add/Remove/Update)
  * Căutare (caută conform cuvintelor cheie)

2. AddtActivity
  * Data/Time controller
  * Info TextBox
  * Buttons
și altele (la discreție conform specificului aplicației)

3. UpdateActivity - practic e una și aceeași activitate de la Add, doar ca completata deja.

Datele operaționale din interiorul aplicației vor fi stocate în fișier/e XML forma cărora rămâne la discreția 
personală. (cuvinte cheie, **XML Serialization**).

###Logical/Operational Component

Toate evenimentele și acțiunile de notificare/semnalizare (sonore/vizuale) intreprinse în Organiser
vor fi tratate într-un **serviciu** aparte, care logic funcțional va extrage datele din acel fișier XML.



La discreția fiecărui rămâne tema/funcționalul aplicației. Exemplu cum se va modifica tema(specificată in raport) :


Funcțional: Planificator al orarului de studii.
Tema: Student Organiser

Funcțional: Planificator al administrărilor medicamentoase.
Tema: Medication Reminder

etc.


