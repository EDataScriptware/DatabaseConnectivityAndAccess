﻿/***
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floser
   *Database Connectivity and Access
***/
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MySQLDatabase
{
    class MySQLDatabase
    {
        string mysqlConnStr = "server=127.0.0.1;Database=travel;uid=root;pwd=student;";
        MySqlConnection conn2;

        // Public method
        public MySQLDatabase()
        {
            try
            {
                if (connect() != false)
                {
                    // Open the database
                    Console.WriteLine("Database Opens");
                }

                // MySql close db
                close();
            }
            catch (MySqlException E)
            {
                Console.WriteLine("MySql Error: " + E.Message);
                Console.WriteLine("MySql " + E.StackTrace);
            }
        }

        // Connect method
        public Boolean connect()
        {
            try
            {
                conn2 = new MySqlConnection(mysqlConnStr);
                return true;
            }
            catch (MySqlException e)
            {
                Console.WriteLine("Could not connect to Database " + e);
                return false;
            }
        }

        // Close method
        public Boolean close()
        {
            try
            {
                if (conn2 != null)
                {
                    conn2.Close();
                    Console.WriteLine("Database successfully closed.");
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine("Could not connect to Database " + e);
                return false;
            }
        }
    }
}
