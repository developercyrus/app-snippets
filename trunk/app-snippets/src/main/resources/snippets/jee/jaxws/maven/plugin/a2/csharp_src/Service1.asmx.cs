using System;
using System.Web.Services;
using System.Net;
using System.Net.NetworkInformation;

namespace snippets.jee.jaxws.maven.plugin.a2.stub
{
    [WebService]
    public class Service1 : WebService
    {
        [WebMethod]
        public String sayHello()
        {
            return "Hello World from " + this.getHostname();
        }

        public String getHostname()
        {
            string domainName = IPGlobalProperties.GetIPGlobalProperties().DomainName;
            string hostName = Dns.GetHostName();
            string fqdn = "";
            if (!hostName.Contains(domainName))
                fqdn = hostName + "." + domainName;
            else
                fqdn = hostName;

            return fqdn;
        }
    }
}
