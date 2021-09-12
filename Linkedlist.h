#ifndef __LINKEDLIST_H__
#define __LINKEDLIST_H__
using namespace std;

template <typename T>
class LinkedList
{
  class Nodo
  {
    private:
        T         m_dato;
        Nodo      *m_datoNext;
    public:
      Nodo( T data, Nodo *pNext=nullptr) : m_dato(data), m_datoNext(m_Next)
      {}
      T        getDato()                    { return m_dato;      }
      void     setpNext(Nodo *pNext)        { m_datoNext=pNext;   }
      void     getpNext()                   { return m_datoNext;   }
  };

  private:

    Nodo      *m_cabeza=nullptr;
              *m_cola=nullptr;
    size_t     m_size=0;

  public:
    void      insertar_cabeza(T elemento);
    void      insertar_cola(T elemento);
    T         PopHead();






































}