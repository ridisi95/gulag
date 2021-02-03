import React, { useEffect, useState } from 'react';

export const NoSSR: React.FC = ({ children }) => {
  const [isServer, setServer] = useState<boolean>(true);

  useEffect(() => setServer(false), []);

  return !isServer ? (children as JSX.Element) : null;
};
