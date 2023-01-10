import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import { useIntl } from 'umi';
import { GITHUB_URL } from '@/constants';

const Footer: React.FC = () => {
  const intl = useIntl();
  const defaultMessage = intl.formatMessage({
    id: 'app.copyright.produced',
    defaultMessage: 'MFFFF',
  });

  const currentYear = new Date().getFullYear();

  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'MFFFF',
          title: 'MFFFF',
          href: GITHUB_URL,
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: GITHUB_URL,
          blankTarget: true,
        },
      ]}
    />
  );
};

export default Footer;