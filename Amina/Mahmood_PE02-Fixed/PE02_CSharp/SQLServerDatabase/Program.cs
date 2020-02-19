/***
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floser
   *Database Connectivity and Access
***/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MySQLDatabase
{
    class Program
    {
        // Main method
        static void Main(String[] args)
        {
            Console.WriteLine("My SQL Database is running... ");
            MySQLDatabase mySQLDB = new MySQLDatabase();

            Console.WriteLine("\n\nSQL Server Database is running... ");
            SQLServerDatabase SQLDB = new SQLServerDatabase();

            Console.WriteLine("\n\nDone");

            Console.ReadLine();
        }
    }
}
